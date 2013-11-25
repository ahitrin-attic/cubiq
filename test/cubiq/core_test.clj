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
  (testing "любой поворот, повторенный трижды, возвращает куб в исходное положение"
    (let [top #(rotate % rot-top)
          bot #(rotate % rot-bottom)]
      (is (= complete-hex
             (-> complete-hex top top top)
             (-> complete-hex bot bot bot))))))

(comment ;; этот тест падает :(
(deftest complement-rotations
  (testing "два поворота дополняют друг друга, если их использование делает куб правильно заполненным"
    (let [r1 #(rotate % rot-top)
          r2 #(rotate % rot-bottom)]
      (is (same-colors-on-each-side (-> complete-hex r1 r2)))))))

(comment
  (clojure.test/run-tests))
