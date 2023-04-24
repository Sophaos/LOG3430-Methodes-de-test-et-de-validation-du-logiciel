import SharedBox from '../src/sharedbox.js';
import Helpers from '../src/modules/Helpers/Helpers.js';
import SharedBoxException from '../src/modules/SharedBoxException.js';
let assert = require('chai').assert;
let expect = require('chai').expect;
let sinon = require('sinon');

export default describe('Client', () => {
  let client;
  let recipient;
  let sharedBox;
  beforeEach(() => {
    client = new SharedBox.Client('apiToken', 1, 'endpoint');
    //Example of Recipient object
    let exempleRecipient = {
      id: '59adbccb-87cc-4224-bfd7-314dae796e48',
      firstName: 'John',
      lastName: 'Doe',
      email: 'john.doe@email.com',
      options: {
        locked: false,
        bouncedEmail: false,
        verified: false,
        contactMethods: [{
          id: 1,
          destination: '+55555555555',
          destinationType: 'office_phone',
          verified: false,
          createdAt: '2018-09-01T16:26:07-04:00',
          updatedAt: '2018-09-01T16:26:07-04:00'
        },
        {
          id: 2,
          destination: '+1111111111',
          destinationType: 'cell_phone',
          verified: true,
          createdAt: '2018-09-01T16:26:07-04:00',
          updatedAt: '2018-09-01T16:26:07-04:00'
        }]
      }
    };
    recipient = new Helpers.Recipient(exempleRecipient);
    //Example of Sharedbox object
    let exempleSharedBox = {
      userEmail: 'user@acme.com',
      guid: '1c820789a50747df8746aa5d71922a3f',
      uploadUrl: 'upload_url',
      recipients: [ /* list of Recipient objects*/ ],
      attachments: [ /*list of Attachment objects*/ ],
      message: 'lorem ipsum...',
      subject: 'Donec rutrum congue leo eget malesuada.',
      notificationLanguage: 'en',
      securityOptions: {
        allowRememberMe: true,
        allowSms: true,
        allowVoice: true,
        allowEmail: true,
        expirationValue: 5,
        expirationUnit: 'days',
        retentionPeriodType: 'do_not_discard',
        retentionPeriodValue: null,
        retentionPeriodUnit: 'hours',
        allowManualClose: true
      },
      userId: 1,
      status: 'in_progress',
      previewUrl: 'http://sharedbox.com/sharedboxes/dhjewg67ewtfg476/preview',
      createdAt: '2018-05-24T14:45:35.062Z',
      updatedAt: '2018-05-24T14:45:35.589Z',
      expiration: '2018-05-31T14:45:35.038Z',
      closedAt: null
    };
    sharedBox = new Helpers.Sharedbox(exempleSharedBox);
  });

  describe('initializeSharedbox', () => {
    it('should return The updated SharedBox object with the GUID and the upload URL', () => {
      sinon.stub(client.jsonClient, 'initializeSharedBox').resolves({
        //initializeSharedbox JSON response examples
        guid: 'dc6f21e0f02c41123b795e4',
        uploadUrl: 'upload_url',
      });
      return client.initializeSharedBox({
        userEmail: 'user@acme.com'
      }).then(res => {
        expect(res.guid).to.equals('dc6f21e0f02c41123b795e4');
        expect(res.uploadUrl).to.equals('upload_url');
      });
    });
    it('should throw error if it had an error', () => {
      sinon.stub(client.jsonClient, 'initializeSharedBox').rejects(new Error);
      return client.initializeSharedBox({
        userEmail: 'user@acme.com'
      }).then(() => { assert(false); }, e => { expect(e).to.be.an('error'); });
    });
  });

  describe('submitSharedBox', () => {
    it('should return the Updated Sharedbox filled out', () => {
      sinon.stub(client.jsonClient, 'submitSharedBox').resolves({
        //initializeSharedbox JSON response examples
        guid: 'dc6f21e0f02c41123b795e4',
        uploadUrl: 'upload_url'
      });
      return client.submitSharedBox(sharedBox).then(res => {
        expect(res).to.be.an('Object').to.have.all.keys('expiration', 'guid', 'message', 'notificationLanguage', 'securityOptions', 'subject','uploadUrl', 'userEmail');
      });
    });
    it('should be an error when SharedBox GUID null', () => {
      sharedBox.guid = null;
      expect(() => {
        client.submitSharedBox(sharedBox);
      }).to.throw(SharedBoxException);
    });
    it('should be an error when SharedBox GUID undefined', () => {
      sharedBox.guid = undefined;
      expect(() => {
        client.submitSharedBox(sharedBox);
      }).to.throw(SharedBoxException);
    });
    it('should throw error if it had an error', () => {
      sinon.stub(client.jsonClient, 'submitSharedBox').rejects(new Error);
      return client.submitSharedBox(sharedBox).then(() => {
        assert(false);
      }, res => { expect(res).to.be.an('error'); });
    });
  });

  describe('uploadAttachment', () => {
    let attachment = {
      stream: 'stream',
      contentType: 'contenttype',
      filename: 'filename',
      guid: 'none'
    };
    it('should return the updated Attachment object with the GUID parameter filled out', () => {
      //uploadFile JSON response examples
      let response = {
        temporaryDocument: {
          documentGuid: '65f53ec1282c454fa98439dbda134093'
        }
      };
      sinon.stub(client.jsonClient, 'uploadFile').withArgs(sinon.match.string, sinon.match.object).onFirstCall().resolves(response);
      return client.uploadAttachment(sharedBox, attachment).then(res => {
        expect(res.guid).to.equals(response.temporaryDocument.documentGuid);
      });
    });
  });

  describe('addRecipient', () => {
    it('should return the updated Recipient', () => {
      sinon.stub(client.jsonClient, 'addRecipient').resolves('response');
      return client.addRecipient(sharedBox, recipient).then(res => {
        recipient = new Helpers.Recipient(Object.assign(recipient.toObject(), 'response'));
        expect(res.id).to.equals(recipient.id);
        expect(res.email).to.equals(recipient.email);
        expect(res.firstName).to.equals(recipient.firstName);
        expect(res.lastName).to.equals(recipient.lastName);
      });
    });
    it('should be an error when SharedBox GUID is null', () => {
      sharedBox.guid = null;
      let spy = sinon.spy(client, 'addRecipient');
      try {
        client.addRecipient(sharedBox, recipient);
      } catch (e) {
        expect(e.message).to.equals('SharedBox GUID cannot be null or undefined');
      }
      expect(spy.threw()).to.be.true;
    });
    it('should be an error when SharedBox GUID is undefined', () => {
      sharedBox.guid = undefined;
      let spy = sinon.spy(client, 'addRecipient');
      try {
        client.addRecipient(sharedBox, recipient);
      } catch (e) {
        expect(e.message).to.equals('SharedBox GUID cannot be null or undefined');
      }
      expect(spy.threw()).to.be.true;
    });
    it('should be an error when Recipient email is null', () => {
      recipient.email = null;
      let spy = sinon.spy(client, 'addRecipient');
      try {
        client.addRecipient(sharedBox, recipient);
      } catch (e) {
        expect(e.message).to.equals('Recipient email cannot be null or undefined');
      }
      expect(spy.threw()).to.be.true;
    });
    it('should be an error when Recipient email is undefined', () => {
      recipient.email = undefined;
      expect(() => {
        client.addRecipient(sharedBox, recipient);
      }).to.throw(SharedBoxException);
    });
  });

  describe('closeSharedbox', () => {
    it('should return the request result', () => {
      sinon.stub(client.jsonClient, 'closeSharedbox').withArgs(sinon.match.string).resolves({
        //closeSharedbox JSON response examples
        'result': true,
        'message': 'SharedBox successfully closed.'
      });
      return client.closeSharedbox(sharedBox).then(res => {
        expect(res.message).to.equals('SharedBox successfully closed.');
        expect(res.result).to.be.true;
      });
    });
    it('should be an error when SharedBox GUID is null', () => {
      sharedBox.guid = null;
      let spy = sinon.spy(client, 'addRecipient');
      try {
        client.addRecipient(sharedBox, recipient);
      } catch (e) {
        expect(e.message).to.equals('SharedBox GUID cannot be null or undefined');
      }
      expect(spy.threw()).to.be.true;
    });
    it('should be an error when SharedBox GUID is undefined', () => {
      sharedBox.guid = undefined;
      expect(() => {
        client.addRecipient(sharedBox, recipient);
      }).to.throw(SharedBoxException);
    });
  });
});