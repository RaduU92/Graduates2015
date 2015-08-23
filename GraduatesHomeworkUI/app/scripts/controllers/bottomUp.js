/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('BottomUpCtrl', function bottomUpConfig($scope, BottomUpService) {
    var bottomNodeId = 7;
    var upNodeId = 1;
    BottomUpService.bottomUpConfig(bottomNodeId, upNodeId, function (data) {
      $scope.configuration = data;
    });
  });
