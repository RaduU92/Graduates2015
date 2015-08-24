/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('BottomUpCtrl', function bottomUpConfig($scope, BottomUpService, AllNodesService) {
    $scope.bottomUpF = function () {
      BottomUpService.bottomUpConfig($scope.bottomNodeId, $scope.upNodeId).then(function (response) {
        $scope.configuration = response.data;
      }, function (response) {
        $scope.configuration = response.data;
      });
    };
    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
