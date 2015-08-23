/**
 * Created by rursu on 8/21/2015.
 */
'use strict';

angular.module('graduatesHomeworkUiApp')
  .factory('ChildrenService', function ($http) {
    return {
      nodeChildrens: function (id, callback) {
        $http.get('http://localhost:8081/getChildrens/' + id).success(callback);
      }
    }
  });
