/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('AllNodesService', function ($http) {
    return {
      getAll: function () {
        return $http.get('http://localhost:8081/all');
      }
    }
  });
