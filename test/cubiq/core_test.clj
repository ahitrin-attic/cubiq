(ns cubiq.core-test
  (:use clojure.test
        cubiq.core))

(deftest different-slices
  (testing "разные срезы куба в сумме содержат одинаковые ячейки"
    (is (= (set (concat triangles smallings))
           (set (concat up-front-side up-side up-back-left-side up-back-right-side
                   down-side down-front-left-side down-front-right-side down-back-side))))))

(deftest rotation-function
  (testing "функция поворота работает нормально"
    (is (= (rotate {:a :b :c :d :e :f} {:c :a :a :c})
           {:a :d :c :b :e :f}))))

(deftest verify-rotations
  (testing "повороты написаны правильно"
    (is (= complete-skewb-hex-example
           (rotate (rotate (rotate complete-skewb-hex-example rot-top)
                           rot-top)
                   rot-top)))))

(comment
  (clojure.test/run-tests))
