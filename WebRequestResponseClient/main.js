var module = angular.module("mainModule", []);

var controller = module.controller("mainController", ["$scope", function($scope) {
  
  function onResultReceived(typedResponseReceivedEventArgs) {
    $scope.result = typedResponseReceivedEventArgs.ResponseMessage.Result;
    $scope.$apply();
    
  }
  
   var myPiSender = new DuplexTypedMessageSender();
    myPiSender.onResponseReceived = onResultReceived;
  
  $scope.openConnection = function() {
    var anOutputChannel = new WebSocketDuplexOutputChannel("ws://127.0.0.1:8091/PiCalculator/", null);
    myPiSender.attachDuplexOutputChannel(anOutputChannel);
  };
  
  $scope.closeConnection = function() {
    myPiSender.detachDuplexOutputChannel();
  };
  
  $scope.sendRequestMessage = function() {
    var aRequestMessage = {
      CalculationStep: 0.01
    };
    myPiSender.sendRequestMessage(aRequestMessage);
  };
}]);