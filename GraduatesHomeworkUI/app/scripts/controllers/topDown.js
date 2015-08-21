/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('topDownApp', [])
  .controller('TopDownCtrl', function topDownConfig($scope, $http) {
    $http.get('http://localhost:8081/topDownConfig/idT=1&idD=12').success(function (data) {
      $scope.configuration = data;
    });
  });
