/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('ParentCtrl', function getParent($scope, ParentService, AllNodesService) {
    $scope.getParent = function () {
      ParentService.nodeParent($scope.id).then(function (response) {
        $scope.parent = response.data;
      }, function (response) {
        $scope.parent = response.data;
      });
    };
    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
