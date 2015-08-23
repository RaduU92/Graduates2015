/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('NodeCtrl', function getNode($scope, NodeService) {
    var id = 7;
    NodeService.myNode(id, function (data) {
      $scope.nod = data;
    });
  });
