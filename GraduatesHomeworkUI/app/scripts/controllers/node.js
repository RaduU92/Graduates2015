/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('NodeCtrl', function getNode($scope, NodeService, AllNodesService) {
    $scope.read = function () {
      NodeService.myNode($scope.id).then(function (response) {
        $scope.nod = response.data;
      }, function (response) {
        $scope.nod = response.data;
      });
    };
    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
