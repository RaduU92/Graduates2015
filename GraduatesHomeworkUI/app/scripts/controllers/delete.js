/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('DeleteCtrl', function delNode($scope, DeleteService, AllNodesService) {
    $scope.deleteTheNode = function () {
      var nodeInfo = {
        id: $scope.nodeId
      };
      DeleteService.deleteNode(nodeInfo).then(function (response) {
        $scope.message = response.data;
      }, function (response) {
        $scope.message = response.data;
      });
    };
    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
