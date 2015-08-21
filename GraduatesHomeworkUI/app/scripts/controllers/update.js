/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('updateApp', [])
  .controller('UpdateCtrl', function updateNode($scope, $http) {
    var nodeInfo = {
      "id": 1,
      "json": {
        "key": "zzz"
      }
    };
    var res = $http.put('http://localhost:8081/update', nodeInfo);
    res.success(function (data) {
      $scope.message = data;
    });
    res.error(function (data) {
      $scope.message = data;
    });
  });
