/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('TopDownService', function ($http) {
    return {
      topDownConfig: function (topNodeId, downNodeId) {
        return $http.get('http://localhost:8081/topDownConfig/idT=' + topNodeId + '&idD=' + downNodeId);
      }
    }
  });
