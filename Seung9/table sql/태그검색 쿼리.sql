SELECT  P_ROWNUM , P_TITLE, T_NAMELIST, 
          P_REGDATE, P_LIKE FROM BOARDVIEW
          where t_namelist like '%#������%'
        ORDER BY P_like DESC;

                        
SELECT  P_ROWNUM , P_TITLE, T_NAMELIST,
          P_REGDATE, P_LIKE FROM BOARDVIEW
          where t_namelist = 'ddd'
        ORDER BY P_ROWNUM DESC;

                        
SELECT COUNT(P_ROWNUM) FROM BOARDVIEW
where t_namelist like '%#������%';


SELECT COUNT(P_ROWNUM) FROM BOARDVIEW;

commit;


SELECT S_SERIALNUM, E_NAME, E_LOCATION, E_STARTDATE,
       E_ENDDATE, E_PHOTO, E_URL 
       FROM EVENT WHERE E_STARTDATE IS NOT NULL 
       AND E_ENDDATE IS NOT NULL;