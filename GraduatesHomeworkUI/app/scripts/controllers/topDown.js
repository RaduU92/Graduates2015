/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('TopDownCtrl', function topDownConfig($scope, TopDownService) {
    var topNodeId = 1;
    var downNodeId = 7;
    TopDownService.topDownConfig(topNodeId, downNodeId, function (data) {
      $scope.configuration = data;
    });
  });
