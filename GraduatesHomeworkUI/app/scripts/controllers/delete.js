/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('DeleteCtrl', function delNode($scope, DeleteService) {
    var nodeId = 14;
    var nodeInfo = {
      id: nodeId
    };
    DeleteService.deleteNode(nodeInfo, function (data) {
      $scope.message = data;
    });
  });
