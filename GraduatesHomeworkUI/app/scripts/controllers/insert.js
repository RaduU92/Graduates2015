/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('InsertCtrl', function insertNode($scope, InsertService, AllNodesService) {
    $scope.addNewNode = function () {
      var key = $scope.key;
      //var nodeInfo = {
      //  json: {
      //    key: $scope.info
      //  },
      //  parentId: $scope.parentId
      //};

      var nodeInfo = {};
      var key1 = "json";
      var json = {};
      var keyJ = $scope.key;
      json[keyJ] = $scope.info;
      nodeInfo[key1] = json;
      var key2 = "parentId";
      nodeInfo[key2] = $scope.parentId;
      
      InsertService.newNode(nodeInfo).then(function (response) {
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
