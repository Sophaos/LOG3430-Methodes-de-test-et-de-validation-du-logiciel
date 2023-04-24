import SharedBox from '../src/sharedbox.js';
import * as Utils from '../src/Utils/platform.js';
let expect = require('chai').expect;
let assert = require('chai').assert;
let sinon = require('sinon');

export default describe('JsonCLient', () => {
  let fetch;
  let jsonClient;
  beforeEach(() => {
    fetch = sinon.stub(Utils, 'fetch').withArgs(sinon.match.string, sinon.match.object);
    jsonClient = new SharedBox.JsonClient('', 0, '', true);
  });
  afterEach(() => { sinon.restore(); });
  let stub = (call, ok, text, status, json) => {
    fetch.onCall(call).resolves({
      ok: ok,
      text: () => { return text; },
      status: status,
      json: () => { return json; }
    });
  };
  describe('initializeSharedBox', () => {
    it('should return The json containing the guid and the upload url of the initialized SharedBox', () => {
      stub(0, true, 'text', 204, 'ok');
      stub(1, true, new Promise((resolve) => { resolve('ok'); }), 666, 'ok');
      return jsonClient.initializeSharedBox('ok').then(res => { expect(res).to.equal('ok'); }, () => {
        assert(false);
      });
    });
  });

  describe('addRecipient', () => {
    it('should return The json containing all information on new Recipient', () => {
      let stub = sinon.stub(jsonClient, '_makeRequest').withArgs(sinon.match.string, sinon.match.object).resolves('');
      return jsonClient.addRecipient('guid', 'recipientJson').then(() => {
        expect(stub.calledWith('api/sharedboxes/guid/recipients', {
          headers: {
            'Authorization-Token': jsonClient.apiToken,
            'Content-Type': 'application/json'
          },
          method: 'post',
          body: 'recipientJson'
        })).to.be.true;
      });
    });
  });

  describe('closeSharedbox', () => {
    it('should return The json containing the request result', () => {
      let stub = sinon.stub(jsonClient, '_makeRequest').withArgs(sinon.match.string, sinon.match.object).resolves('');
      jsonClient.closeSharedbox('666');
      expect(stub.calledWith('api/sharedboxes/666/close', {
        headers: {
          'Authorization-Token': jsonClient.apiToken,
          'Content-Type': 'application/json'
        },
        method: 'patch'
      })).to.be.true;
    });
  });
});