function ProtoBufLoader(ProtoBuf) {
    var confirmationReceipt;
    var enrollmentConfirmation;
    var initialRequest;
    var initialResponse;
    var message;
    var publicKey;
    var requestContents;
    var responseContents;
    var devicePlatform;
    var requestType;
    var responseType;
    var messageType;
    var ProtoBuf = dcodeIO.ProtoBuf;

    var confirmationReceiptBuilder;
    var enrollmentConfirmationBuilder;
    var initialRequestBuilder;
    var initialResponseBuilder;
    var messageBuilder;
    var publicKeyBuilder;
    var requestContentsBuilder;
    var responseContentsBuilder;
    var devicePlatformBuilder;
    var requestTypeBuilder;
    var responseTypeBuilder;
    var messageTypeBuilder;


    this.loadAll = function () {
        
        return new Promise(function (resolve, rejct) {
            return Promise.all([new getConfirmationReceipt(),
                            new getEnrollmentConfirmation(),
                            new getInitialRequest(),
                            new getInitialResponse(),
                            new getInitialResponse(),
                            new getPublicKey(),
                            new getRequestContents(),
                            new getResponseContents(),
                            new getDevicePlatform(),
                            new getRequestType(),
                            new getResponseType(),
                            new getMessageType()]).then(function (result) {
                                resolve( {
                                    ConfirmationReceiptBuilder: result[0],
                                    EnrollmentConfirmationBuilder: result[1],
                                    InitialRequestBuilder: result[2],
                                    InitialResponseBuilder: result[3],
                                    MessageBuilder: result[4],
                                    PublicKeyBuilder: result[5],
                                    RequestContentsBuilder: result[6],
                                    ResponseContentsBuilder: result[7],
                                    DevicePlatformBuilder: result[8],
                                    RequestTypeBuilder: result[9],
                                    ResponseTypeBuilder: result[10],
                                    MessageTypeBuilder: result[11]
                                });
                            });

        });

        
    };

    function getConfirmationReceipt() {
        return new Promise(function (resolve, reject) {
            if (confirmationReceipt) {
                resolve(confirmationReceipt);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/ConfirmationReceipt.proto", resolve, reject);
            }
        });
    }

    function getEnrollmentConfirmation() {
        return new Promise(function (resolve, reject) {
            if (enrollmentConfirmation) {
                resolve(enrollmentConfirmation);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/EnrollmentConfirmation.proto", resolve, reject);
            }
        });
    };

    function getInitialRequest() {
        return new Promise(function (resolve, reject) {
            if (initialRequest) {
                resolve(initialRequest);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/InitialRequest.proto", resolve, reject);
            }
        });
    };

    function getInitialResponse() {
        return new Promise(function (resolve, reject) {
            if (initialResponse) {
                resolve(initialResponse);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/InitialResponse.proto", resolve, reject);
            }
        });
    };


    function getInitialResponse() {
        return new Promise(function (resolve, reject) {
            if (message) {
                resolve(message);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/Message.proto", resolve, reject);
            }
        });
    };

    function getPublicKey() {
        return new Promise(function (resolve, reject) {
            if (publicKey) {
                resolve(publicKey);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/PublicKey.proto", resolve, reject);
            }
        });
    };

    function getRequestContents() {
        return new Promise(function (resolve, reject) {
            if (requestContents) {
                resolve(requestContents);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/RequestContents.proto", resolve, reject);
            }
        });
    };

    function getResponseContents() {
        return new Promise(function (resolve, reject) {
            if (responseContents) {
                resolve(responseContents);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/ResponseContents.proto", resolve, reject);
            }
        });
    };

    function getDevicePlatform() {
        return new Promise(function (resolve, reject) {
            if (devicePlatform) {
                resolve(devicePlatform);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/InitialRequest.proto", resolve, reject);
            }
        });
    };

    function getRequestType() {
        return new Promise(function (resolve, reject) {
            if (requestType) {
                resolve(requestType);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/RequestContents.proto", resolve, reject);
            }
        });
    };

        function getResponseType() {
        return new Promise(function (resolve, reject) {
            if (responseType) {
                resolve(responseType);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/ResponseContents.proto", resolve, reject);
            }
        });
    };

     function getMessageType() {
        return new Promise(function (resolve, reject) {
            if (messageType) {
                resolve(messageType);
            } else {
                loadProtoBufFileAndBuildDefault("./protoBuf/Message.proto", resolve, reject);
            }
        });
    };

    function loadProtoBufFileAndBuildDefault(path, resolve, reject) {
        ProtoBuf.loadProtoFile(path, function (error, builder) {
            if (error) {
                reject(error);
            } else {
                resolve(builder);
            }
        });
    }
}