/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('UpdateParentCtrl', function updateParent($scope, UpdateParentService) {
    var nodeId = 12;
    var parentNodeId = 14;
    var nodeInfo = {
      id: nodeId,
      parentId: parentNodeId
    };
    UpdateParentService.updateNodeParent(nodeInfo, function (data) {
      $scope.message = data;
    });
  });
