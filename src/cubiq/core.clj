(ns cubiq.core)

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

