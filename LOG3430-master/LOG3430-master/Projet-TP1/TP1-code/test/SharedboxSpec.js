import SharedBox from '../src/sharedbox';
let expect = require('chai').expect;

export default describe('SharedBox', () => {
  let exemple;
  let sharedBox;
  beforeEach(() => {
    exemple = {
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
    sharedBox = new SharedBox.Helpers.Sharedbox(exemple);
  });

  describe('constructor', () => {
    it('should be equal to all non-securityOptions values', () => {
      expect(sharedBox.userEmail).to.equal(exemple.userEmail);
      expect(sharedBox.guid).to.equal(exemple.guid);
      expect(sharedBox.uploadUrl).to.equal(exemple.uploadUrl);
      expect(sharedBox.recipients).to.be.deep.equal(exemple.recipients);
      expect(sharedBox.attachments).to.be.deep.equal(exemple.attachments);
      expect(sharedBox.message).to.equal(exemple.message);
      expect(sharedBox.subject).to.equal(exemple.subject);
      expect(sharedBox.notificationLanguage).to.equal(exemple.notificationLanguage);
      expect(sharedBox.userId).to.equal(exemple.userId);
      expect(sharedBox.status).to.equal(exemple.status);
      expect(sharedBox.previewUrl).to.equal(exemple.previewUrl);
      expect(sharedBox.createdAt).to.equal(exemple.createdAt);
      expect(sharedBox.updatedAt).to.equal(exemple.updatedAt);
      expect(sharedBox.expiration).to.equal(exemple.expiration);
      expect(sharedBox.closedAt).to.equal(exemple.closedAt);
    });
    it('shoudl be equal to all securityOptions values', () => {
      expect(sharedBox.securityOptions.allowRememberMe).to.equal(exemple.securityOptions.allowRememberMe);
      expect(sharedBox.securityOptions.allowSms).to.equal(exemple.securityOptions.allowSms);
      expect(sharedBox.securityOptions.allowVoice).to.equal(exemple.securityOptions.allowVoice);
      expect(sharedBox.securityOptions.allowEmail).to.equal(exemple.securityOptions.allowEmail);
      expect(sharedBox.securityOptions.expirationValue).to.equal(exemple.securityOptions.expirationValue);
      expect(sharedBox.securityOptions.expirationUnit).to.equal(exemple.securityOptions.expirationUnit);
      expect(sharedBox.securityOptions.retentionPeriodType).to.equal(exemple.securityOptions.retentionPeriodType);
      expect(sharedBox.securityOptions.retentionPeriodValue).to.equal(exemple.securityOptions.retentionPeriodValue);
      expect(sharedBox.securityOptions.retentionPeriodUnit).to.equal(exemple.securityOptions.retentionPeriodUnit);
      expect(sharedBox.securityOptions.allowManualClose).to.equal(exemple.securityOptions.allowManualClose);
    });
  });
  describe('toJson', () => {
    it('should transform to Json format', () => {
      // appropriate conversion
      let test = new SharedBox.Helpers.Sharedbox(JSON.parse(sharedBox.toJson()));

      // values that works
      expect(test.recipients).to.be.deep.equal(sharedBox.recipients);
      expect(test.attachments).to.be.deep.equal(sharedBox.attachments);

      // values that do not
      expect(test.userEmail).to.equal(sharedBox.userEmail);
      expect(test.guid).to.equal(sharedBox.guid);
      expect(test.uploadUrl).to.equal(sharedBox.uploadUrl);
      expect(test.message).to.equal(sharedBox.message);
      expect(test.subject).to.equal(sharedBox.subject);
      expect(test.notificationLanguage).to.equal(sharedBox.notificationLanguage);
      expect(test.userId).to.equal(sharedBox.userId);
      expect(test.status).to.equal(sharedBox.status);
      expect(test.previewUrl).to.equal(sharedBox.previewUrl);
      expect(test.createdAt).to.equal(sharedBox.createdAt);
      expect(test.updatedAt).to.equal(sharedBox.updatedAt);
      expect(test.expiration).to.equal(sharedBox.expiration);
      expect(test.closedAt).to.equal(sharedBox.closedAt);
      expect(test.securityOptions.allowRememberMe).to.equal(sharedBox.securityOptions.allowRememberMe);
      expect(test.securityOptions.allowSms).to.equal(sharedBox.securityOptions.allowSms);
      expect(test.securityOptions.allowVoice).to.equal(sharedBox.securityOptions.allowVoice);
      expect(test.securityOptions.allowEmail).to.equal(sharedBox.securityOptions.allowEmail);
      expect(test.securityOptions.expirationValue).to.equal(sharedBox.securityOptions.expirationValue);
      expect(test.securityOptions.expirationUnit).to.equal(sharedBox.securityOptions.expirationUnit);
      expect(test.securityOptions.retentionPeriodType).to.equal(sharedBox.securityOptions.retentionPeriodType);
      expect(test.securityOptions.retentionPeriodValue).to.equal(sharedBox.securityOptions.retentionPeriodValue);
      expect(test.securityOptions.retentionPeriodUnit).to.equal(sharedBox.securityOptions.retentionPeriodUnit);
      expect(test.securityOptions.allowManualClose).to.equal(sharedBox.securityOptions.allowManualClose);

    });
  });
});