/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('deleteApp', [])
  .controller('DeleteCtrl', function delNode($scope, $http) {
    var nodeInfo = {
      "id": 19
    };
    var res = $http.delete('http://localhost:8081/delete', nodeInfo);
    res.success(function (data) {
      $scope.message = data;
    });
    res.error(function (data) {
      $scope.message = data;
    });
  });
