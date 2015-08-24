/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('InsertCtrl', function insertNode($scope, InsertService, AllNodesService) {
    $scope.addNewNode = function () {
      var nodeInfo = {
        json: {
          key: $scope.info
        },
        parentId: $scope.parentId
      };
      InsertService.newNode(nodeInfo).then(function (response) {
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
