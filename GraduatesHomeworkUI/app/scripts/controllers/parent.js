/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('ParentCtrl', function getParent($scope, ParentService) {
    var nodeId = 2;
    ParentService.nodeParent(nodeId, function (data) {
      $scope.parent = data;
    });
  });
