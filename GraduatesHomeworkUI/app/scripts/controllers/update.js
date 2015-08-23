/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('UpdateCtrl', function updateNode($scope, UpdateService) {
    var nodeId = 14;
    var content = "new node added";
    var nodeInfo = {
      id: nodeId,
      json: {
        key: content
      }
    };
    UpdateService.updateNode(nodeInfo, function (data) {
      $scope.message = data;
    });
  });
