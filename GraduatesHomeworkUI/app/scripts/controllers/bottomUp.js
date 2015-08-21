/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('bottomUpApp', [])
  .controller('BottomUpCtrl', function bottomUpConfig($scope, $http) {
    $http.get('http://localhost:8081/bottomUpConfig/idB=12&idU=1').success(function (data) {
      $scope.configuration = data;
    });
  });
