/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('ParentService', function ($http) {
    return {
      nodeParent: function (nodeId) {
        return $http.get('http://localhost:8081/getParent/' + nodeId);
      }
    }
  });
