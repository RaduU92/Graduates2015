/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('ChildrenCtrl', function getChildrens($scope, ChildrenService, AllNodesService) {
    $scope.getChilds = function () {
      ChildrenService.nodeChildrens($scope.id).then(function (response) {
        $scope.childs = response.data;
      }, function (response) {
        $scope.childs = response.data;
      });
    };

    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
