SELECT COUNT(ID) FISH_COUNT, MONTH(TIME) AS MONTH
FROM FISH_INFO
GROUP BY MONTH
ORDER BY MONTH;