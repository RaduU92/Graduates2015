/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .controller('ChildrenCtrl', function getChildrens($scope, ChildrenService) {
    var id = 1;
    ChildrenService.nodeChildrens(id, function (data) {
      $scope.childs = data;
    });
  });
