import SharedBox from '../src/sharedbox';
let expect = require('chai').expect;
export default describe('Recipient', () => {
  let exemple;
  let recipient;
  beforeEach(() => {
    exemple = { //Example of Recipient object
      'id': '59adbccb-87cc-4224-bfd7-314dae796e48',
      'firstName': 'John',
      'lastName': 'Doe',
      'email': 'john.doe@email.com',
      'options': {
        'locked': false,
        'bouncedEmail': false,
        'verified': false,
        'contactMethods': [
          {
            'id': 1,
            'destination': '+55555555555',
            'destinationType': 'office_phone',
            'verified': false,
            'createdAt': '2018-09-01T16:26:07-04:00',
            'updatedAt': '2018-09-01T16:26:07-04:00'
          },
          {
            'id': 2,
            'destination': '+1111111111',
            'destinationType': 'cell_phone',
            'verified': true,
            'createdAt': '2018-09-01T16:26:07-04:00',
            'updatedAt': '2018-09-01T16:26:07-04:00'
          }
        ]
      }
    };
    recipient = new SharedBox.Helpers.Recipient(exemple);
  });

  describe('Construteur', () => {
    describe('non-options', () => {
      it('should be the same values for id, firstName, lastName, email', () => {
        expect(recipient.id).to.equal(exemple.id);
        expect(recipient.firstName).to.equal(exemple.firstName);
        expect(recipient.lastName).to.equal(exemple.lastName);
        expect(recipient.email).to.equal(exemple.email);
      });
    });
    describe('options', () => {
      it('should be the same values for locked, bouncedEmail, verified', () => {
        expect(recipient.options.locked).to.equal(exemple.options.locked);
        expect(recipient.options.bouncedEmail).to.equal(exemple.options.bouncedEmail);
        expect(recipient.options.verified).to.equal(exemple.options.verified);
        expect(recipient.options.contactMethods.length).to.equal(exemple.options.contactMethods.length);
      });
      describe('contactMethods', () => {
        describe('[0]', () => {
          it('should be the same values for id, destination, destinationType, verified, createdAt, updateAt', () => {
            expect(recipient.options.contactMethods[0].id).to.equal(exemple.options.contactMethods[0].id);
            expect(recipient.options.contactMethods[0].destination).to.equal(exemple.options.contactMethods[0].destination);
            expect(recipient.options.contactMethods[0].destinationType).to.equal(exemple.options.contactMethods[0].destinationType);
            expect(recipient.options.contactMethods[0].verified).to.equal(exemple.options.contactMethods[0].verified);
            expect(recipient.options.contactMethods[0].createdAt).to.equal(exemple.options.contactMethods[0].createdAt);
            expect(recipient.options.contactMethods[0].updateAt).to.equal(exemple.options.contactMethods[0].updateAt);
          });
        });
        describe('[1]', () => {
          it('should be the same values for id, destination, destinationType, verified, createdAt, updateAt', () => {
            expect(recipient.options.contactMethods[1].id).to.equal(exemple.options.contactMethods[1].id);
            expect(recipient.options.contactMethods[1].destination).to.equal(exemple.options.contactMethods[1].destination);
            expect(recipient.options.contactMethods[1].destinationType).to.equal(exemple.options.contactMethods[1].destinationType);
            expect(recipient.options.contactMethods[1].verified).to.equal(exemple.options.contactMethods[1].verified);
            expect(recipient.options.contactMethods[1].createdAt).to.equal(exemple.options.contactMethods[1].createdAt);
            expect(recipient.options.contactMethods[1].updateAt).to.equal(exemple.options.contactMethods[1].updateAt);
          });
        });
      });
    });
  });
  describe('toJson', () => {
    it('should transform to Json', () => {
      // appropriate conversion
      let test = new SharedBox.Helpers.Recipient(JSON.parse(recipient.toJson()));
      expect(test.id).to.equal(recipient.id);
      expect(test.firstName).to.equal(recipient.firstName);
      expect(test.lastName).to.equal(recipient.lastName);
      expect(test.email).to.equal(recipient.email);
      expect(test.options.locked).to.equal(recipient.options.locked);
      expect(test.options.bouncedEmail).to.equal(recipient.options.bouncedEmail);
      expect(test.options.verified).to.equal(recipient.options.verified);
      expect(test.options.contactMethods.length).to.equal(recipient.options.contactMethods.length);
      expect(test.options.contactMethods[0].id).to.equal(recipient.options.contactMethods[0].id);
      expect(test.options.contactMethods[0].destination).to.equal(recipient.options.contactMethods[0].destination);
      expect(test.options.contactMethods[0].destinationType).to.equal(recipient.options.contactMethods[0].destinationType);
      expect(test.options.contactMethods[0].verified).to.equal(recipient.options.contactMethods[0].verified);
      expect(test.options.contactMethods[0].createdAt).to.equal(recipient.options.contactMethods[0].createdAt);
      expect(test.options.contactMethods[0].updateAt).to.equal(recipient.options.contactMethods[0].updateAt);
      expect(test.options.contactMethods[1].id).to.equal(recipient.options.contactMethods[1].id);
      expect(test.options.contactMethods[1].destination).to.equal(recipient.options.contactMethods[1].destination);
      expect(test.options.contactMethods[1].destinationType).to.equal(recipient.options.contactMethods[1].destinationType);
      expect(test.options.contactMethods[1].verified).to.equal(recipient.options.contactMethods[1].verified);
      expect(test.options.contactMethods[1].createdAt).to.equal(recipient.options.contactMethods[1].createdAt);
      expect(test.options.contactMethods[1].updateAt).to.equal(recipient.options.contactMethods[1].updateAt);
    });
  });
});
