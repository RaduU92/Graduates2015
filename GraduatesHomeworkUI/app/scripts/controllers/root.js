/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('rootApp', [])
  .controller('RootCtrl', function getRoot($scope, $http) {
    $http.get('http://localhost:8081/getRoot').success(function (data) {
      $scope.root = data;
    });
  });
