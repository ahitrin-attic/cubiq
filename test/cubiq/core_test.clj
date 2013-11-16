(ns cubiq.core-test
  (:use clojure.test
        cubiq.core))

(deftest different-slices
  (testing "разные срезы куба в сумме содержат одинаковые ячейки"
    (is (= (set (concat triangles smallings))
           (set (concat up-front-side up-side up-back-left-side up-back-right-side
                   down-side down-front-left-side down-front-right-side down-back-side))))))

(comment
  (clojure.test/run-tests))
