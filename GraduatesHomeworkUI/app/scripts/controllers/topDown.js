/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('TopDownCtrl', function topDownConfig($scope, TopDownService, AllNodesService) {
    $scope.topDownF = function () {
      TopDownService.topDownConfig($scope.topNodeId, $scope.downNodeId).then(function (response) {
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
