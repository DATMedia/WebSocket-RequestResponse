var module = angular.module("mainModule", []);

var controller = module.controller("mainController", ["$scope", function($scope) {

  var chatMessage;
  try{
    var ProtoBuf = dcodeIO.ProtoBuf;
    //message = ProtoBuf.loadProtoFile("chatMessage.proto").build("ChatMessage");

    ProtoBuf.loadProtoFile("./protoBuf/chatMessage.proto", function (error, builder) {
      if (error) {
        $scope.result = error;
        $scope.$apply();
      } else {
        chatMessage = builder.build("ChatMessage");
      }
    });
  } catch (error) {
    $scope.result = error;
    $scope.$apply();
  }

  function onResultReceived(typedResponseReceivedEventArgs) {
    var message = chatMessage.decode(typedResponseReceivedEventArgs.ResponseMessage);
    $scope.result = message.Name;
    $scope.$apply();
    
  }
  
   var myPiSender = new DuplexTypedMessageSender();
    myPiSender.onResponseReceived = onResultReceived;
  
  $scope.openConnection = function() {
    var anOutputChannel = new WebSocketDuplexOutputChannel("ws://192.168.15.124:8091/", null);
    myPiSender.attachDuplexOutputChannel(anOutputChannel);
  };
  
  $scope.closeConnection = function() {
    myPiSender.detachDuplexOutputChannel();
  };
  
  $scope.sendRequestMessage = function() {
    var message = new chatMessage();
    message.setName($scope.sendText);
    message.setDateTime(Date.now());
    message.setText("Hello Eneter");

    var messageInArrayBuffer = message.toArrayBuffer();

    myPiSender.sendRequestMessage(messageInArrayBuffer);
  };
}]);