/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('nodeApp', [])
  .controller('NodeCtrl', function getNode($scope, $http) {
    $http.get('http://localhost:8081/select/10').success(function (data) {
      $scope.nod = data;
    });
  });
