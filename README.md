# PointInPolygon

Finding out whether a point is inside a polygon is a common and useful task in computational geometry.

Consider an input file that has several input cases.  Each input case gives the number n of vertices on a polygon and then the number of points m that will be queried to see if they are inside the polygon.

The n vertices are given as x and y values on the next n lines in clockwise order.  All vertices have integer coordinates.  Polygons may not be convex, but they are guaranteed not to be self-intersecting.

The m queries are given on the next m lines, also as x and y values.  After each input case is a blank line.

For each point query in each input case, print "in" if the point is inside the polygon and "out" if the point is outside the polygon.  Points on the boundary of a polygon are considered to be inside.
