/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('parentApp', [])
  .controller('ParentCtrl', function getParent($scope, $http) {
    $http.get('http://localhost:8081/getParent/10').success(function (data) {
      $scope.parent = data;
    });
  });
