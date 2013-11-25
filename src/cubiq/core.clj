(ns cubiq.core)

;; Эта штука называется Skewb Hex

;; треугольники
(def triangles #{ :up :down :up-front :down-back :up-back-left :up-back-right :down-front-left :down-front-right })
;; боковушки
(def smallings #{ :u-uf-ubl :u-uf-ubr :u-ubl-ubr
                :d-db-dfl :d-db-dfr :d-dfl-dfr
                :uf-u-dfl :uf-u-dfr :uf-dfl-dfr
                :db-d-ubl :db-d-ubr :db-ubl-ubr
                :dfl-uf-ubl :dfl-uf-d :dfl-ubl-d
                :ubr-db-dfr :ubr-db-u :ubr-dfr-u
                :dfr-uf-ubr :dfr-uf-d :dfr-ubr-d
                :ubl-db-dfl :ubl-db-u :ubl-dfl-u})
;; по сторонам
(def up-front-side #{:up-front :uf-u-dfl :uf-u-dfr :uf-dfl-dfr})
(def up-side #{:up :u-uf-ubl :u-uf-ubr :u-ubl-ubr})
(def up-back-left-side #{:up-back-left :ubl-db-dfl :ubl-db-u :ubl-dfl-u})
(def up-back-right-side #{:up-back-right :ubr-db-dfr :ubr-db-u :ubr-dfr-u})
(def down-side #{:down :d-db-dfl :d-db-dfr :d-dfl-dfr})
(def down-front-left-side #{:down-front-left :dfl-uf-ubl :dfl-uf-d :dfl-ubl-d})
(def down-front-right-side #{:down-front-right :dfr-uf-ubr :dfr-uf-d :dfr-ubr-d})
(def down-back-side #{:down-back :db-d-ubl :db-d-ubr :db-ubl-ubr})

;; цвета
(def colors #{:white :red :yellow :orange :gray :pink :blue :darkblue})

(defn painted [side color]
  (zipmap side (repeat color)))

(def complete-skewb-hex-example
  (merge
    (painted up-front-side :white)
    (painted up-side :red)
    (painted up-back-left-side :darkblue)
    (painted up-back-right-side :pink)
    (painted down-side :orange)
    (painted down-front-left-side :yellow)
    (painted down-front-right-side :blue)
    (painted down-back-side :gray)))

;; выборка всех цветов с конкретной стороны
(defn colors-on-side [hex side]
  (vals (select-keys hex side)))
;; (colors-on-side complete-skewb-hex-example down-side)

;; повороты
(defn rotate [source rot]
  "source - исходный куб, rot - карта преобразования старых вершин в новые"
  (apply assoc source (flatten (for [x rot] (list (x 0) (source (x 1)))))))

(defn round [a b c]
  "меняет местами по кругу a, b и c"
  { a b b c c a })

(def rot-top (merge
  (round :up-back-left :up-back-right :up-front)
  (round :u-uf-ubl :u-uf-ubr :u-ubl-ubr)
  (round :uf-u-dfl :ubl-db-u :ubr-dfr-u)
  (round :uf-u-dfr :ubl-db-dfl :ubr-db-dfr)))
