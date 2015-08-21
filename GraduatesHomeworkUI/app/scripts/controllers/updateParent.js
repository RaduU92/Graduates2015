/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('updateParentApp', [])
  .controller('UpdateParentCtrl', function updateParent($scope, $http) {
    var nodeInfo = {
      "id": 14,
      "parentId": 8
    };
    var res = $http.put('http://localhost:8081/updateParent', nodeInfo);
    res.success(function (data) {
      $scope.message = data;
    });
    res.error(function (data) {
      $scope.message = data;
    });
  });
