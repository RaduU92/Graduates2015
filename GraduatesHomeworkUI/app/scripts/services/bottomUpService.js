/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('BottomUpService', function ($http) {
    return {
      bottomUpConfig: function (bottomNodeId, upNodeId, callback) {
        $http.get('http://localhost:8081/bottomUpConfig/idB=' + bottomNodeId + '&idU=' + upNodeId).success(callback);
      }
    }
  });
