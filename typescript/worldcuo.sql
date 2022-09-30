select teams.team_id, team_name, num_points from (

select team_id, sum(num_points) as num_points
from (
select team_id, count(*) * 3 as num_points from (
select host_team as team_id from matches
where host_goals > guest_goals
union 
select guest_team as team_id from matches
where guest_goals > host_goals
) as wins group by (team_id)

union

select team_id, count(*) as num_points from (
    select host_team as team_id from matches
    where host_goals = guest_goals
    union select guest_team as team_id from matches
    where guest_goals = host_goals
) as draws group by (team_id)

union

select team_id, count(*) * 0 as num_points from (
select host_team as team_id from matches
    where host_goals < guest_goals
    union select guest_team as team_id from matches
    where guest_goals < host_goals
) as loses group by (team_id)


) as points_table group by (team_id)
) as table_points, teams
where table_points.team_id = teams.team_id order by num_points desc, teams.team_id asc

