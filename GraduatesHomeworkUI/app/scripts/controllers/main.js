'use strict';

/**
 * @ngdoc function
 * @name graduatesHomeworkUiApp.controller:MainCtrl
 * @description
 * # MainCtrl
 * Controller of the graduatesHomeworkUiApp
 */
angular.module('graduatesHomeworkUiApp')
  .controller('MainCtrl', function ($scope, TreeConfigService) {
    TreeConfigService.getTree().then(function (response) {
      $scope.tree = response.data;
    }, function (response) {
      $scope.tree = response.data;
    });
  });
