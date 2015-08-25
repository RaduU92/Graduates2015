/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('TreeConfigService', function ($http) {
    return {
      getTree: function () {
        return $http.get('http://localhost:8081/tree');
      }
    }
  });
