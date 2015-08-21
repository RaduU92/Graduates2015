/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('insertApp', [])
  .controller('InsertCtrl', function insertNode($scope, $http) {
    var nodeInfo = {
      "json": {
        "key": "json"
      },
      "parentId": 1
    };
    var res = $http.post('http://localhost:8081/insert', nodeInfo);
    res.success(function (data) {
      $scope.message = data;
    });
    res.error(function (data) {
      $scope.message = data;
    });
  });
