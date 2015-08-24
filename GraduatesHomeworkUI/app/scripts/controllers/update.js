/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('UpdateCtrl', function updateNode($scope, UpdateService, AllNodesService) {
    $scope.updateNode = function () {
      //var nodeInfo = {
      //  id: $scope.nodeId,
      //  json: {
      //    key: $scope.info
      //  }
      //};
      var nodeInfo = {};
      var key1 = "id";
      nodeInfo[key1] = $scope.nodeId;
      var key2 = "json";
      var json = {};
      var keyJ = $scope.key;
      json[keyJ] = $scope.info;
      nodeInfo[key2] = json;

      UpdateService.updateNode(nodeInfo).then(function (response) {
        $scope.message = response.data;
      }, function (response) {
        $scope.message = response.data;
      });
    }
    ;
    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
