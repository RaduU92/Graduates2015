/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('RootCtrl', function getRoot($scope, RootService) {
    RootService.getRoot().then(function (response) {
      $scope.root = response.data;
    }, function (response) {
      $scope.root = response.data;
    });
  });
