var exec = require('cordova/exec');

module.exports = {
    open: function (message, onSuccess, onError) {
        exec(onSuccess, onError, "tel", "open", [message]);
    }
};
