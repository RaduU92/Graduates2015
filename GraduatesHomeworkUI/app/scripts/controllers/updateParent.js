/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('UpdateParentCtrl', function updateParent($scope, UpdateParentService, AllNodesService) {
    $scope.modifyParent = function () {
      var nodeInfo = {
        id: $scope.nodeId,
        parentId: $scope.parentNodeId
      };
      UpdateParentService.updateNodeParent(nodeInfo).then(function (response) {
        $scope.message = response.data;
      }, function (response) {
        $scope.message = response.data;
      });

      $scope.nodeId = '';
      $scope.parentNodeId = '';
      window.location.reload();
    };
    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
