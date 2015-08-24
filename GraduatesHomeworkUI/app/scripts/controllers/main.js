'use strict';

/**
 * @ngdoc function
 * @name graduatesHomeworkUiApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the graduatesHomeworkUiApp
 */
angular.module('graduatesHomeworkUiApp')
  .controller('MainCtrl', function ($scope, AllNodesService) {
    AllNodesService.getAll().then(function (response) {
      $scope.nodes = response.data;
    }, function (response) {
      $scope.nodes = response.data;
    });
  });
