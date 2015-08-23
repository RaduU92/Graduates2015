/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('InsertCtrl', function insertNode($scope, InsertService) {
    var content = "test";
    var parentId = 1;
    var nodeInfo = {
      json: {
        key: content
      },
      parentId: parentId
    };
    InsertService.newNode(nodeInfo, function (data) {
      $scope.message = data;
    });
  });
